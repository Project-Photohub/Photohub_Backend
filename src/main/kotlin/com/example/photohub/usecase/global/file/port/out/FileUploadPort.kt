package com.example.photohub.usecase.global.file.port.out

import org.springframework.web.multipart.MultipartFile

/**
 * 파일 저장소에 파일 업로드
 *
 * @author Daybreak312
 * @since 18-06-2024
 */
interface FileUploadPort {

    /**
     * 파일 저장소에 [MultipartFile]을 업로드
     *
     * @return 업로드된 파일을 찾을 수 있는 key
     */
    fun uploadFile(file: MultipartFile): String
}