# Presigned URL Demo

This project demonstrates how to generate a presigned URL for uploading files to an Amazon S3 bucket using a Spring Boot application with Kotlin.

## Overview
A presigned URL is a URL that you can provide to your users to grant temporary access to a specific S3 object. Using the URL, a user can either READ the object or WRITE an Object (or update an existing object). This project includes a Spring Boot application that generates a presigned URL for uploading files to an S3 bucket.

## API Endpoint

### Generating a Presigned URL
To generate a presigned URL, make a GET request to the `/generate-presigned-url` endpoint with the required parameters: `bucketName`, `keyName`, and `content`.

### Query Parameters
- `bucketName`: The name of the S3 bucket.
- `keyName`: The key name of the file to upload.
- `content`: The content type of the file.

### Example request using Postman or curl:
curl -X GET "http://localhost:8080/generate-presigned-url bucketName=*******&keyName=********&content=text/plain"

### Response
A URL string that can be used to upload a file to the specified S3 bucket.

### Common Issues
- **404 Not Found**: Ensure the endpoint URL is correct and the application is running.
- **AWS Credentials**: Ensure your AWS credentials are correctly configured and accessible.
- **Region Configuration**: Ensure the AWS region is specified correctly in both the application properties and the configuration class.

## Project Structure

- **src/main/kotlin**: Contains the Kotlin source files.
  - **config**: Configuration classes for AWS S3.
  - **controller**: REST controllers for handling API requests.
  - **service**: Service classes for business logic.
- **src/main/resources**: Contains the application properties file.
- **build.gradle.kts**: The Gradle build file.




