package UpdateFirstName;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdateFirstName {


	@Test
    public void UpdateUser() throws IOException {

		 FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Desktop\\ApiTesting\\data\\Book3.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet ws = workbook.getSheetAt(0);

            int rownum  = ws.getLastRowNum();
            int colnum = ws.getRow(0).getPhysicalNumberOfCells();
            System.out.println(colnum);
            System.out.println(rownum);
           
            XSSFCell firstname;
             XSSFCell lastname;

            for(int i = 0; i <= rownum ; i++) {

               
                firstname = ws.getRow(i).getCell(0);
                lastname = ws.getRow(i).getCell(1);

                RestAssured.baseURI = "https://restful-booker.herokuapp.com";

               
                RequestSpecification request = RestAssured.given()
    		    		.auth()
    		    		.preemptive()
    		            .basic("admin", "password123")
    		            .header("Content-Type", "application/json")
    				    .header("Cookie","token=abc123");
    		    		
    		    Response res = request.body("{\"firstname\":\"" + firstname +"\", \"lastname\":\"" + lastname +"\"}").pathParam("id","678").patch("/booking/{id}");
    	       ResponseBody body = res.getBody();
    		    System.out.println("Response Body is: " + body.asString());	

                System.out.println(body.asString());

}
}
}
