package data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Temperature {

	private long id;
	private double value;

	public Temperature() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
