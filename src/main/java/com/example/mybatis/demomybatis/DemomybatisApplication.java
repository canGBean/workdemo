package com.example.mybatis.demomybatis;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.example.mybatis.demomybatis.generatormapper.GeneratorCoffeeMapper;
import com.example.mybatis.demomybatis.generatormodel.GeneratorCoffee;
import com.example.mybatis.demomybatis.generatormodel.GeneratorCoffeeExample;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@Slf4j
@EnableApolloConfig
@MapperScan({"com.example.mybatis.demomybatis.generatormapper"})
public class DemomybatisApplication  implements ApplicationRunner {

//	调用测试时取消注释
	@Autowired
	private GeneratorCoffeeMapper generatorCoffeeMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemomybatisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//生成测试的对象
		//生成测试时先删除响应路径的文件或代码 以方便观察
		//调用测试时先注释掉此方法
//		generatorArtifacts();

		//调用测试
		//注意上面import的注释
//		generatorCoffeeTest();

//		apollo DEV环境测试
//		apolloConfigLoggerTest();

	}

	private void apolloConfigLoggerTest(){
		Logger logger = LoggerFactory.getLogger(DemomybatisApplication.class);
		Executors.newSingleThreadExecutor().submit(()->{
			while (true){
				logger.info("我是info级别日志");
				logger.error("我是error级别日志");
				logger.warn("我是warn级别日志");
				logger.debug("我是debug级别日志");
				TimeUnit.SECONDS.sleep(5);
			}
		});
	}

	private void generatorArtifacts() throws Exception {
		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	private void generatorCoffeeTest() {
		GeneratorCoffee espross = new GeneratorCoffee()
				.withName("AAA")
				.withCreateTime(new Date())
				.withUpdateTime(new Date());
		generatorCoffeeMapper.insert(espross);

		GeneratorCoffee latte = new GeneratorCoffee()
				.withName("BBB")
				.withCreateTime(new Date())
				.withUpdateTime(new Date());
		generatorCoffeeMapper.insert(latte);

		GeneratorCoffee coffee = generatorCoffeeMapper.selectByPrimaryKey(1L);
		log.info("Coffee: {}",coffee);

		GeneratorCoffeeExample coffeeExample = new GeneratorCoffeeExample();
		coffeeExample.createCriteria().andNameEqualTo("latte");
		List<GeneratorCoffee> list = generatorCoffeeMapper.selectByExample(coffeeExample);
		list.forEach(e -> log.info("Coffee SelectByExample:{}",e));
	}
}
