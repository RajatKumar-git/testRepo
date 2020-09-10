package com.dynamoDbexample.demo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dynamoDbexample.repository.DynamoDbOps;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class DemoApplicationTests {
	@Inject
	DynamoDbOps dynamoDbOps;
	@Inject
	DynamoDBMapper dynamoDBMapper;

	@Test
	void dynamoDb() {
		Assertions.assertNotNull(dynamoDbOps);
		Assertions.assertNotNull(dynamoDBMapper);
		Assertions.assertNotNull(dynamoDbOps.getDynamoDBMapper());
	}
}
