package com.example.springboot.api_demo.dto.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestDto {
    /**
     * メールアドレスの正規表現（例）
     * <ul>
     *     <li> 【^[a-zA-Z0-9._%+-]{1,64}】: ローカル部は最大64文字に制限
     *     <li> 【@[a-zA-Z0-9.-]{1,253}】: ドメイン名部分は最大253文字（ドットを含む）に制限
     *     <li> 【\\.[a-zA-Z]{2,}$】: ドメインのTLD（トップレベルドメイン）は2文字以上
     * </ul>
     */
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,253}\\.[a-zA-Z]{2,}$";
    /*
     * リクエストに必要なプロパティのみ用意する
     */
    @NotBlank(message = "名前は必須です。空文字以外の値をセットしてください。")
    private String name;
    @Pattern(regexp = EMAIL_REGEX, message = "メールアドレスは必須です。255文字以内の有効なメールアドレスを入力してください。")
    private String email;
    private boolean isActive;
}