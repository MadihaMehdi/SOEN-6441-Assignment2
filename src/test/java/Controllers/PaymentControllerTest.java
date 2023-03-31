package Controllers;

import org.example.Database.LeaseRepository;
import org.example.Database.TenantRepository;
import org.example.controllers.LeaseController;
import org.example.controllers.PaymentController;
import org.example.controllers.TenantController;
import org.example.models.Tenant;
import org.junit.*;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class PaymentControllerTest {
    LeaseRepository leaseRepository = new LeaseRepository();
    PaymentController controller= new PaymentController(leaseRepository);
    TenantRepository tenantRepository = new TenantRepository();
    TenantController controller2= new TenantController(tenantRepository);

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Starting testing for Payment Controller");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Ending testing for Payment controller");
    }

    @Before
    public  void beforeMethod(){
        System.out.println("Starting test case in Payment Controller");
    }

    @After
    public  void afterMethod(){
        System.out.println("Ending test case in Payment controller");
    }

    @Test
    public void testPayRent(){
        //arrange
        String email="abc@xyz.com" ;
        String name="abc";
        //act
        controller2.createTenant(name,email);
        Tenant tenant = leaseRepository.getSingleTenant(email);
        //assert
        assertEquals(tenant.getName()+ " " + "has paid the rent",controller.payRent(email));
    }

    @Test
    public void testDisplayAllPaidTenants()  {
        //arrange

        //act
        controller.displayAllPaidTenants();
        //assert
    }
}
