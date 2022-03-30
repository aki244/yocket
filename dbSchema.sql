CREATE TABLE IF NOT EXISTS `event` (
  `event_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `event_name` varchar(36) NOT NULL,
  `event_starting_time` timestamp DEFAULT 0,
  `event_duration` time
)