package Edit;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "html:target/Destination","json:target/JsonReport","junit:target/xmlReport"},
tags="@ParameterizedTest",
glue="Edit",
monochrome=true,
dryRun=true

)
public class EditProfileRunner {

}