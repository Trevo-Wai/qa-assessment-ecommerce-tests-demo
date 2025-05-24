// <reference types="cypress" />

describe('Lazada E-commerce Payment Flow (Mocked API)', () => {
  beforeEach(() => {
    // Mock product list
    cy.intercept('GET', '/api/products', { fixture: 'products.json' }).as('getProducts');

    // Mock coupon apply
    cy.intercept('POST', '/api/coupon/apply', { fixture: 'couponSuccess.json' }).as('applyCoupon');

    // Mock payment processing
    cy.intercept('POST', '/api/payment', { fixture: 'paymentSuccess.json' }).as('makePayment');

    // Start from product page
    cy.visit('/products');
    cy.wait('@getProducts');

    // Add product to cart
    cy.contains('Add to Cart').click();

    // Apply coupon
    cy.visit('/cart');
    cy.get('#coupon-code').type('DISCOUNT50');
    cy.get('#apply-coupon').click();
    cy.wait('@applyCoupon');

    // Proceed to checkout
    cy.visit('/checkout');
  });

  it('should successfully complete a payment', () => {
    cy.get('#card-number').type('4111111111111111');
    cy.get('#card-expiry').type('12/26');
    cy.get('#card-cvc').type('123');
    cy.get('#pay-now').click();

    cy.wait('@makePayment').then(({ response }) => {
      expect(response.statusCode).to.eq(200);
      expect(response.body.success).to.be.true;
    });

    cy.contains('Payment processed successfully').should('be.visible');
  });

  it('should show error for failed payment', () => {
    cy.intercept('POST', '/api/payment', {
      statusCode: 402,
      body: {
        success: false,
        message: 'Payment failed due to insufficient funds'
      }
    }).as('failedPayment');

    cy.get('#card-number').clear().type('4000000000000002');
    cy.get('#card-expiry').type('12/26');
    cy.get('#card-cvc').type('999');
    cy.get('#pay-now').click();

    cy.wait('@failedPayment').then(({ response }) => {
      expect(response.statusCode).to.eq(402);
      expect(response.body.success).to.be.false;
    });

    cy.contains('Payment failed due to insufficient funds').should('be.visible');
  });
});