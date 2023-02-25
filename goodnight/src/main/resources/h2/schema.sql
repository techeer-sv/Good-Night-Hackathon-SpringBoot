drop table if exits Restaurant
create table Restaurant (
                            id long PRIMARY KEY AUTO_INCREMENT not null,
                            name varchar(25) not null,
                            category varchar(25) not null,
                            isActivated bool DEFAULT True,
                            createdAt DATE,
                            updatedDate DATE
);

drop table if exits Review
create table Review (
                        id long PRIMARY KEY AUTO_INCREMENT not null,
                        title varchar(45) not null,
                        content varchar(200) not null,
                        createdAt DATE,
                        updatedDate DATE,
                        restaurant_id long not null,
                        foreign key (restaurant_id) references Restaurant(id)
);