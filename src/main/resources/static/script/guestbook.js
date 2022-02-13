function delguestbook(seq) {
    let pwd = prompt("비밀번호를 입력해주세요");

    if(pwd.trim().length <= 0) {
        alert("비밀번호를 입력해주세요");
        return;
    }

    if(confirm("삭제하시겠습니까?")) {
        let url = `/guestbook/guestbookDelete?seq=${seq}&password=${pwd}`;
        location.href=url;
    }
}