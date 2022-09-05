# ToR
## News From Twitch
### Entities:
### User
```
{
  id: number(PK, autoincrement),
  name: string(required, min: 5: max: 20),
  password: string(required, min: 8, max: 30),
  email: string(required, min: 10, max:50)
}

```
### Posts
```
{
  id: number(PK, autoincrement),
  id_user: number(required, FK to id.user),
  article: string(required, min: 10, max: 300),
  title: string(required, min: 3, max: 50),
  img: optional(optional, path to file)
}

```
### Likes
```
{
  id: number(PK, autoincrement),
  id_user: number(required, FK to id.user)
}

```
### Comments
```
{
  id: number(PK, autoincrement),
  id_user: number(required, FK to id.user),
  text: string(required, min: 0, max: 200 )
}

```