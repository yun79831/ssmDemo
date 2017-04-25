package dao;

import com.qwp.core.po.springjdbc.GenericDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by project on 2017/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class GenericDaoTest {
    @Resource
    private GenericDao genericDao;


    @Test
    public void testSql() throws Exception {
        int i = genericDao.getInt("select count(1) from sys_user");
        System.out.println(i);
    }
}
