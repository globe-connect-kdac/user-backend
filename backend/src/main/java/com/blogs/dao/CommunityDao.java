package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogs.pojo.Community;

public interface CommunityDao extends JpaRepository <Community,Long>{

}
