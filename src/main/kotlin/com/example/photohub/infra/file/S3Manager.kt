package com.example.photohub.infra.file

import com.example.photohub.global.Path
import com.example.photohub.infra.env.file.S3Properties
import com.example.photohub.usecase.global.file.port.out.FileUploadPort
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest

@Component
class S3Manager(
    private val s3Client: S3Client,
    private val s3Properties: S3Properties
) : FileUploadPort {

    override fun uploadFile(file: MultipartFile): String {

        val fileId: String = FileNameGenerator()

        s3Client.putObject(
            PutObjectRequest.builder()
                .bucket(s3Properties.bucketName)
                .contentType(file.contentType)
                .contentLength(file.size)
                .key(Path.join(s3Properties.fileNamePrefix, fileId))
                .build(),
            RequestBody.fromInputStream(file.inputStream, file.size)
        )

        return fileId
    }
}