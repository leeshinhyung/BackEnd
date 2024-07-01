insert into app_user (id, password) values (1, 'aaa-zzzz-ddddd');
insert into app_user (id, password) values (2, 'aaa-zzzz-ddddd');

insert into friend_group (id, group_goal, group_name) values (1, 'Hyundai', 'Mazda');
insert into friend_group (id, group_goal, group_name) values (2, 'Volkswagen', 'Ford');

insert into app_user_friend_group (id, app_user_id, friend_group_id)values (1, 1, 1);
insert into app_user_friend_group (id, app_user_id, friend_group_id)
values (2, 2, 2);

insert into plan (id, app_user_id, is_complete, plan_alarm_date, plan_create_date, plan_tag, goal, plan_photo, plan_time, plan_day) values (1, 1, false, '2023-01-14', '2023-01-14', 'Nissan', 'Chevrolet', 'Volvo', '2023-01-14', '2023-01-14');
insert into plan (id, app_user_id, is_complete, plan_alarm_date, plan_create_date, plan_tag, goal, plan_photo, plan_time, plan_day) values (2, 1, true, '2023-01-14', '2023-01-14', 'Lexus', 'Toyota', 'Infiniti', '2023-01-14', '2023-01-14');

insert into setting (id, nickname, plan_alarm, friend_group_alarm, post_alarm, app_alarm, profile_photo, user_id) values (1, 'Kia', false, false, false, false, 'Mitsubishi', 1);
insert into setting (id, nickname, plan_alarm, friend_group_alarm, post_alarm, app_alarm, profile_photo, user_id) values (2, 'Volkswagen', false, false, false, true, 'Jeep', 2);

insert into post (id, app_user_id, post_view, post_like, post_content, post_date, post_is_anonymous, comment_is_anonymous, post_photo) values (1, 1, 1, 1, 'Toyota', '2023-01-14', false, false, 'Chevrolet');
insert into post (id, app_user_id, post_view, post_like, post_content, post_date, post_is_anonymous, comment_is_anonymous, post_photo) values (2, 2, 1, 1, 'Toyota', '2023-01-14', false, false, 'Chevrolet');