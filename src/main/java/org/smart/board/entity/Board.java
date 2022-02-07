package org.smart.board.entity;


import lombok.*;


//@Data   : no,to,s,g
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter @Getter
public class Board {

    private Long boardseq;
    private String usrid;
    private String title;
    private String content;
    private int hitcount;
    private  String regdate;
    private String originalfile;
    private  String savedfile;

}
