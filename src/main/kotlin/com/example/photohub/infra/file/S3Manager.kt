package com.example.photohub.infra.file

import com.example.photohub.global.Path
import com.example.photohub.infra.env.file.S3Properties
import com.example.photohub.usecase.global.file.port.out.FileUploadPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import kotlin.math.log

@Component
class S3Manager(
    private val s3Client: S3Client,
    private val s3Properties: S3Properties
) : FileUploadPort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private lateinit var bucketBaseURL: String
        private var initialized = false
    }

    private fun init() {
        if (!initialized) {
            if (logger.isDebugEnabled) {
                logger.debug("${this.javaClass.name} Initialed")
            }
            bucketBaseURL = Path.join(s3Properties.bucketUrl, s3Properties.fileNamePrefix)
        }
    }

    override fun uploadFile(file: MultipartFile): String {
        init()

        val fileName: String = FileNameGenerator()

        s3Client.putObject(
            PutObjectRequest.builder()
                .bucket(s3Properties.bucketName)
                .contentType(file.contentType)
                .contentLength(file.size)
                .key(fileName)
                .build(),
            RequestBody.fromInputStream(file.inputStream, file.size)
        )

        return Path.join(bucketBaseURL, fileName)
    }
}