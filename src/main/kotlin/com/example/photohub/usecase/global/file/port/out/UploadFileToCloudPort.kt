package com.example.photohub.usecase.global.file.port.out

import org.springframework.web.multipart.MultipartFile

interface UploadFileToCloudPort {

    operator fun invoke(file: MultipartFile): String
}