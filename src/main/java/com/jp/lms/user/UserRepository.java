package com.jp.lms.user;

import com.jp.lms.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
