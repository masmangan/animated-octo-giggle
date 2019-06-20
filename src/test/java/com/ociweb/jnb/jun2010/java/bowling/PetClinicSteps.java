package com.ociweb.jnb.jun2010.java.bowling;

import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Named;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.assertj.core.api.Assertions.assertThat;


public class PetClinicSteps extends Steps {
	Person person = new Person();

	private Validator createValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.afterPropertiesSet();
		return localValidatorFactoryBean;
	}

	Validator validator = createValidator();
	Set<ConstraintViolation<Person>> constraintViolations;

	ConstraintViolation<Person> violation;

	@Given("a person with empty first name")
	public void aPersonWtihEmptyFirstName() {
		person.setFirstName("");
	}

	@Given("$last as last name")
	public void aPersonWithSmithAsLastName(@Named("last") String lastName) {
		person.setLastName(lastName);

	}

	@When("person is validated")
	public void personIsValidated() {
		validator = createValidator();
		constraintViolations = validator.validate(person);

		assertThat(constraintViolations).hasSize(1);
		violation = constraintViolations.iterator().next();
	}

	@Then("invalid field must be $field")
	public void getInvalidField(@Named("field") String field) {
		assertThat(violation.getPropertyPath().toString()).isEqualTo(field);
	}

	@Then("message is $message")
	public void getInvalidMessage(@Named("message") String message) {
		assertThat(violation.getMessage()).isEqualTo(message);
	}

}
