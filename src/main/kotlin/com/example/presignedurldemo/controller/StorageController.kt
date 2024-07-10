package com.example.presignedurldemo.controller

import com.example.presignedurldemo.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import java.net.URL

@RestController
class StorageController @Autowired constructor(
    private val storageService: StorageService,
    private val s3Presigner: S3Presigner
) {

    @GetMapping("/gpurl")
    fun generatePresignedUrl
                (
        @RequestParam bucketName: String,
        @RequestParam keyName: String,
    ): URL {
        val url: URL = storageService.presignedUrl(s3Presigner, bucketName, keyName)
        return url
    }
}