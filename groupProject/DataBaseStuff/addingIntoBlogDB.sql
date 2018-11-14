use blogdb;

insert into category(`name`)
values("News");

insert into tag(`name`)
values("#woah");

insert into tag(`name`)
values("#intro");

insert into tag(`name`)
values("#extra");

insert into post(title, postDate, content, userId, state, referencingId, categoryId)
values("Title1", "2018-10-30", "This is addded content from the sql database", 1, 1, 1, 1);

insert into post(title, postDate, content, userId, state, referencingId, categoryId)
values("Title2", "2018-10-30", "This another post added from the sql database", 1, 1, 1, 1);

insert into category(`name`)
values("Extras");

insert into post(title, postDate, content, userId, state, referencingId, categoryId)
values("Title3", "2018-10-30", "This post should be the only one that shows under Extras category", 1, 1, 1, 2);

insert into postTag(postId, tagId)
values(1, 1);

insert into postTag(postId, tagId)
values(1, 2);

insert into postTag(postId, tagId)
values(1, 3);

insert into postTag(postId, tagId)
values(2, 2);

insert into postTag(postId, tagId)
values(3, 3);

insert into postTag(postId, tagId)
values(3, 1);





