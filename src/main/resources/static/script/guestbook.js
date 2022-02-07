function delguestbook(seq){
    //alert("함수호출" );
    let pwd = prompt("비밀번호를 입력해 주세요");

    if(pwd.trim().length <= 0){
        alert("비밀번호를 입력해 주세요");
        return;
    }

    if(confirm("삭제하시겠습니까?")){
        let url = `/guestbook/guestbookDelete?seq=${seq}&password=${pwd}`;
        location.href = url;
    }

}