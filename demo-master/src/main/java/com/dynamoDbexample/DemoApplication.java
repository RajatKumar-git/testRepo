package com.dynamoDbexample;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@
public class DemoApplication extends Spring{

	@ConfigProperty(name = "dynamoDB.accessKey")
	private String accessKey;

	@ConfigProperty(name = "dynamoDB.secretKey")
	private String secretKey;

	@ConfigProperty(name = "dynamoDB.region")
	private String region;


	@Produces
	public DynamoDBMapper dynamoDBMapper(){
		AWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withCredentials(
				new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();
		return new DynamoDBMapper(client);
	}

}
