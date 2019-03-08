package com.wcy;

import com.wcy.service.ScenarioServer;
import com.wcy.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class ScenarioServerApplication implements CommandLineRunner {

	@Autowired
	ScenarioServer scenarioServer;

	public static void main(String[] args) {
		new SpringApplicationBuilder(ScenarioServerApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		scenarioServer.launchWithPort(8980);
	}
}
