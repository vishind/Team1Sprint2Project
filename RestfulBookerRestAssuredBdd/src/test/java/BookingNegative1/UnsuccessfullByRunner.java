package BookingNegative1;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "html:target/Destination"},
monochrome=true
) 
public class UnsuccessfullByRunner {

}
