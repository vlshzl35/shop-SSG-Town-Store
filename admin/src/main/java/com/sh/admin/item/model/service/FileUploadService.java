package com.sh.admin.item.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class FileUploadService {

    @Autowired
    private ResourceLoader resourceLoader;
    public String uploadBase64EncodedImage(String base64Image) throws IOException {
        // base64Image에는 Base64인코딩된 문자열이 들어있다.
        byte[] decodedByte = Base64.getDecoder().decode(base64Image.split(",")[1]);


        // 2. 파일 경로 및 이름 설정
        Resource resource = resourceLoader.getResource("classpath:static/img");
        String directoryPath = resource.getFile().getAbsolutePath();

        int nextFileNumber = findNextFileNumber(directoryPath); // 다음 파일 번호 찾기
        String fileName = "img" + nextFileNumber + ".png";
        File convertFile = new File(directoryPath, fileName);

        FileOutputStream fos = null;
        try {
//            if(convertFile.exists()){ // 파일이 이미 존재하면 덮어쓰기
//                FileOutputStream fos = new FileOutputStream(convertFile, false); // false: 덮어쓰기 모드
//                fos.write(decodedByte);
//                fos.close();
//            }

            if (convertFile.createNewFile()) { // 파일이 없으면 새로 생성
                fos = new FileOutputStream(convertFile);
                fos.write(decodedByte);
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            fos.close();
        }
        return fileName;
    }

    // 다음 파일 번호 찾기 메서드
    private int findNextFileNumber(String directoryPath) {
        int nextNumber = 1;
        String fileNamePrefix = "img";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith(fileNamePrefix)) {
                    String numberStr = file.getName().substring(fileNamePrefix.length(), file.getName().lastIndexOf("."));
                    try {
                        int number = Integer.parseInt(numberStr);
                        if (number >= nextNumber) {
                            nextNumber = number + 1;
                        }
                    } catch (NumberFormatException e) {
                        // 파일 이름에서 숫자를 추출할 수 없는 경우
                        continue;
                    }
                }
            }
        }

        return nextNumber;
    }
}
