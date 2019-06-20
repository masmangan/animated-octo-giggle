package com.ociweb.jnb.jun2010.java.bowling;

import javax.validation.constraints.NotEmpty;

public class Person {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @NotEmpty
    private String firstName;


    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
