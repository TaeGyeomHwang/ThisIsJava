package ch08.example.exam5;

public class Concert {
	String name;
	int capacity;
	int soldTicket = 0;
	int priceOnline;
	int priceOffline;
	int totalPrice;
	boolean isOnline = true;
	int ticketNum = 0;
	int finalTicket = 0;
	int finalPrice = 0;

	public Concert(String name, int capacity, int priceOnline, int priceOffline) {
		this.name = name;
		this.capacity = capacity;
		this.priceOnline = priceOnline;
		this.priceOffline = priceOffline;
	}

	public String getName() {
		return this.name;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int ticketNum) {
		this.capacity -= ticketNum;
	}

	public void setSoldTicket(int ticketNum) {
		this.soldTicket = ticketNum;
	}

	public int getPriceOnline() {
		return this.priceOnline;
	}

	public int getPriceOffline() {
		return this.priceOffline;
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		if (this.getIsOnline() == true) {
			totalPrice = this.getTicketNum() * this.getPriceOnline();
			this.finalPrice += totalPrice;
			return totalPrice;
		} else {
			totalPrice = this.getTicketNum() * this.getPriceOffline();
			this.finalPrice += totalPrice;
			return totalPrice;
		}
	}

	public boolean getIsOnline() {
		return this.isOnline;
	}

	public void setIsOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public int getLeftTicket() {
		return this.getCapacity();
	}

	public int getTicketNum() {
		return this.ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
		this.finalTicket += ticketNum;
	}

	public int getFinalTicket() {
		return this.finalTicket;
	}

	public int getFinalPrice() {
		return this.finalPrice;
	}

}
