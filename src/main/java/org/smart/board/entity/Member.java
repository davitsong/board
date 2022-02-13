package org.smart.board.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Member implements UserDetails {
    private String usrid;
    private String usrpwd;
    private String usrname;
    private String email;
    private boolean enabled;
    private String rolename;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.usrpwd;
    }

    /**
     * 시큐리티에서는 usrname이 id와 같은 역할을 수행하도록 설계되었음.
     * @return
     */
    @Override
    public String getUsername() {
        return this.usrid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
