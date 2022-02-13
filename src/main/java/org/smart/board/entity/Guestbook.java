package org.smart.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guestbook {
    private Long seq;
    private String usrname;
    private String usrpwd;
    private String text;
    private String regdate;
}
