package com.learn.housePrice;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learn.housePrice.dao")
public class HousePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousePriceApplication.class, args);
	}
}
