package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepDefinitions",
    dryRun = false,
    plugin = {
    "pretty",
    "html:test-output",
    "json:target/cucumber.json"
},
    monochrome = true,
    publish = true,
    tags = "@AddToCartFeature"
)
public class TestRunner {
    
}
