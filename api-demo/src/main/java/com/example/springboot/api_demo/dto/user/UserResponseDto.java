package com.example.springboot.api_demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    /*
     * レスポンスに必要なプロパティのみ用意する
     *
     * 「yyyy/MM/dd HH:mm:ss」 のような時間が必要な場合は、
     * createdAtやupdatedAtをそのままの命名で渡すのではなく、
     * 新規で用途に合わせた命名で用意する（xxxxxAtやxxxxxTimeなど）
     */
    private Long id;
    private String name;
    private String email;

    @JsonProperty("isActive")
    private boolean isActive;
}