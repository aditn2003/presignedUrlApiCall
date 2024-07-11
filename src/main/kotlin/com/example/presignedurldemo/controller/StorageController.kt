package com.example.presignedurldemo.controller

import java.net.URL
import com.example.presignedurldemo.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.s3.presigner.S3Presigner


@RestController 
class StorageController @Autowired constructor(
    private val storageService: StorageService,
    private val s3Presigner: S3Presigner
) {
    @Operation(
        operationId = "GENERATE_PRESIGNED_UPLOAD_URL",
        summary = "Generate a presigned URL to upload large files directly to S3 storage bucket"
    )
    
    @GetMapping("/get-presigned-upload-url")
    fun generatePresignedUploadUrl(
        @RequestParam bucketName: String,
        @RequestParam keyName: String,
    ): URL {
        val url: URL = storageService.presignedPutUrl(s3Presigner, bucketName, keyName)
        return url
    }

    @Operation(
        operationId = "GENERATE_PRESIGNED_DOWNLOAD_URL",
        summary = "Generate a presigned URL to download files directly from S3 storage bucket"
    )

    @GetMapping("/get-presigned-download-url")
    fun generatePresignedDownloadUrl(
        @RequestParam bucketName: String,
        @RequestParam keyName: String,
    ): URL {
        val url: URL = storageService.presignedGetUrl(s3Presigner, bucketName, keyName)
        return url
    }
}
