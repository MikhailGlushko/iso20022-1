package net.toregard.service;

import net.toregard.entities.Product;
import net.toregard.persistence.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.*;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductServiceImpl target;

    @Before
    public void before(){
        //MockitoAnnotations.initMocks(this);
        target = new ProductServiceImpl();
        target.setProductRepository(productRepository);
    }

    @After
    public void after(){
        MockitoAnnotations.initMocks(this);
        target = null;
    }

    @Test
    public void createProductTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        Product product = Product.builder()
                .price(100.0)
                .description("ProductA")
                .id(1L)
                .name("ProductNameA")
                .updatedTime(dateTime).build();

        when(productRepository.saveAndFlush(Matchers.any())).thenReturn(product);
        Product retrievedProduct = target.createProduct("ProductA", "ProductNameA", 100.0);
        Assert.assertNotNull(retrievedProduct);
        assertThat(retrievedProduct, is(equalTo(product)));
        assertThat(retrievedProduct.getUpdatedTime(), is(equalTo(dateTime)));
    }
}
