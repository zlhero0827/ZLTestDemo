package mockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

/**
 * 参考文献：http://blog.csdn.net/zhoudaxia/article/details/33056093
 */
public class PersonServiceTest {

    @Mock
    private PersonDao personDAO;
    private PersonService personService;

    public PersonServiceTest(){}

    @BeforeClass
    public static void setUpClass(){}

    @AfterClass
    public static void tearDownClass(){}

    @Before
    public void setUp() throws Exception{
        //初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
        //用模拟对象创建被测类对象
        personService = new PersonService(personDAO);
    }

    @After
    public void teatDown(){}

    @Test
    public void shouldUpdatePersonName(){
        Person person = new Person(1,"Jason");
        //设置返回对象的模拟预期值
        when(personDAO.fetchPerson(1)).thenReturn(person);
        //执行测试
        boolean updated = personService.update(1,"HERO");
        //验证更新是否成功
        assertTrue(updated);
        //验证模拟对象的fetchPerson(1)方法是否被调用了一次
        verify(personDAO).fetchPerson(1);
        //得到一个抓取器
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        //验证模拟对象update()是否被调用一次，并抓取调用时传入的参数值
        verify(personDAO).update(personCaptor.capture());
        //获取抓取到的参数值
        Person updatePerson = personCaptor.getValue();
        //验证调用时的参数值
        assertEquals("HERO",updatePerson.getPersonName());
        //检查模拟对象上是否还有未验证的交互
        verifyNoMoreInteractions(personDAO);
    }

    @Test
    public void shouldNotUpdateIfPersonNotFound(){
        //设置模拟对象的返回预期值
        when(personDAO.fetchPerson(1)).thenReturn(null);
        //执行测试
        boolean updated = personService.update(1,"Jason");
        //验证更新是否失败
        assertFalse(updated);
        //验证模拟对象的fetchPerson(1)方法是否被调用了一次
        verify(personDAO).fetchPerson(1);
        //验证模拟对象是否没有发生任何交互
        verifyZeroInteractions(personDAO);
        //检查模拟对象上是否还有未验证的交互
        verifyNoMoreInteractions(personDAO);
    }

    /*
    @Test
    public void testUpdate(){
        System.out.println("update");
        Integer personId = null;
        String name = "Jason";
        PersonService instance = new PersonService(new PersonDao() {
            @Override
            public Person fetchPerson(Integer personID) {
                System.out.println("Not supported yet");
                return null;
            }

            @Override
            public void update(Person person) {
                System.out.println("Not supported yet");
            }
        });
        boolean expResult = false;
        boolean result = instance.update(personId,name);
        assertEquals(expResult,result);

        fail("The test case is a prototype");
    }
    */
}
