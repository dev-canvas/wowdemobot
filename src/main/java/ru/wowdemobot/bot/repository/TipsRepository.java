package ru.wowdemobot.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.wowdemobot.bot.entity.Tips;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipsRepository extends JpaRepository<Tips, UUID> {
    @Query(value = "SELECT * FROM tips WHERE category = ?1 ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Tips> findRandomByCategory (String category);
}
