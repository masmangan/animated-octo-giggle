package com.ociweb.jnb.jun2010.java.bowling;

import org.jbehave.scenario.MostUsefulConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import org.jbehave.scenario.reporters.FilePrintStreamFactory;
import org.jbehave.scenario.reporters.ScenarioReporter;
import org.jbehave.scenario.reporters.ScenarioReporterBuilder;

import static org.jbehave.scenario.reporters.ScenarioReporterBuilder.Format.*;

public class PetClinicScenario extends Scenario {
    public PetClinicScenario() {
        super(new PetClinicSteps());
        useConfiguration(new MostUsefulConfiguration() {

        @Override
        public ScenarioReporter forReportingScenarios() {
            return new ScenarioReporterBuilder(new FilePrintStreamFactory(PetClinicScenario.class, new UnderscoredCamelCaseResolver()))
                        .outputTo("jbehave-reports")
                        .with(CONSOLE)
                        .with(TXT)
                        .with(HTML)
                        .with(XML)
                        .build();
            }
        });
    }
}

