package ru.app.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.app.notification.document.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    
}
