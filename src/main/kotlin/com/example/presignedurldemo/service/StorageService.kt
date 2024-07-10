package com.example.presignedurldemo.service

import org.springframework.stereotype.Service
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest
import java.net.URL
import kotlin.time.Duration.Companion.hours
import kotlin.time.toJavaDuration

@Service
class StorageService {

    fun presignedUrl(s3Presigner: S3Presigner,
                     bucketName: String,
                     keyName: String,
                     ): URL {

        val objectRequest = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(keyName)
            .build()

        val presignRequest = PutObjectPresignRequest.builder()
            .signatureDuration(1.hours.toJavaDuration())
            .putObjectRequest(objectRequest)
            .build()

        val presignedRequest = s3Presigner.presignPutObject(presignRequest)

        return presignedRequest.url()
    }
}
