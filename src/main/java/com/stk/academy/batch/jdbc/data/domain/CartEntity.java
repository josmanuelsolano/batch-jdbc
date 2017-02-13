package com.stk.academy.batch.jdbc.data.domain;

public class CartEntity extends Audit{
	
	private Long id;
	private Double linesAmount;
	private Double shippingAmount;
	private Double cartAmount;
	private ShipToEntity shipTo;
	private StatusEntity status;

	
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLinesAmount() {
        return this.linesAmount;
    }

    public void setLinesAmount(Double linesAmount) {
        this.linesAmount = linesAmount;
    }

    public Double getShippingAmount() {
        return this.shippingAmount;
    }

    public void setShippingAmount(Double shipToAmount) {
        this.shippingAmount = shipToAmount;
    }

    public Double getCartAmount() {
        return this.cartAmount;
    }

    public void setCartAmount(Double cartAmount) {
        this.cartAmount = cartAmount;
    }

    public ShipToEntity getShipTo() {
        return this.shipTo;
    }

    public void setShipTo(ShipToEntity shipTo) {
        this.shipTo = shipTo;
    }

    public StatusEntity getStatus() {
        return this.status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
    
    @Override
	public String toString() {
		return "Cart [id=" + this.id + ", linesAmount=" + this.linesAmount + ", shippingAmount=" + this.shippingAmount
				+ ", cartAmount=" + this.cartAmount + ", shipTo=" + this.shipTo + ", status=" + this.status
				+ ", createUser=" + this.createUser + ", createDate=" + this.createDate + ", updateUser="
				+ this.updateUser + ", updateDate=" + this.updateDate + "]";
	}

}
