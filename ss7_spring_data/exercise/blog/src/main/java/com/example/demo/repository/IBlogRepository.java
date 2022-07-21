package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

   @Query(value = "select * from blog where status = 0 and title like :title",
           countQuery = "SELECT count(*) FROM blog where status = 0 and title like :title"
           ,nativeQuery = true)
   Page<Blog> findAllSearch(@Param("title") String title, Pageable pageable);


   @Modifying
   @Query(value = "insert into blog(title,content,date_write,category_id) values(:title,:content,:date,:category)", nativeQuery = true)
   void save(@Param("title") String title,
             @Param("content") String content,
             @Param("date") String date,
             @Param("category") Integer category);

   @Modifying
   @Query(value = "update blog set title = :title,content = :content, date_write = :dateWrite, category_id = :category where id = :id", nativeQuery = true)
   void updateBlog(@Param("title") String title,
                   @Param("content") String content,
                   @Param("dateWrite") String date,
                   @Param("category") Category category,
                   @Param("id") Integer id);


   @Query(value = "select * from blog where id = :id", nativeQuery = true)
   Blog findByIdBlog(@Param("id") Integer id);

   @Modifying
   @Query(value = " update blog set status = 1 where id = :id", nativeQuery = true)
   void deleteBlog(@Param("id") Integer id);

}
