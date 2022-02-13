package org.smart.board.entity;

import lombok.*;

//
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    private Long boardseq;    // x
    private String usrid;     // x
    private String title;     // o
    private String content;   // o
    private int hitcount;     // x
    private String regdate;   // x
    private String originalfile; //
    private String savedfile;
}
