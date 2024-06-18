package com.example.photohub.infra.file

import com.example.photohub.infra.env.file.S3Properties
import com.example.photohub.usecase.global.file.port.out.UploadFileToCloudPort
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest

@Component
class S3FileToCloudUploader(
    private val s3Client: S3Client,
    private val s3Properties: S3Properties
) : UploadFileToCloudPort {

    override fun invoke(file: MultipartFile): String {
        val fileName: String = s3Properties.fileNamePrefix + FileNameGenerator()

        s3Client.putObject(
            PutObjectRequest.builder()
                .bucket(s3Properties.bucketName)
                .contentType(file.contentType)
                .contentLength(file.size)
                .key(fileName)
                .build(),
            RequestBody.fromInputStream(file.inputStream, file.size)
        )

        return s3Properties.bucketUrl + "/" + fileName
    }
}