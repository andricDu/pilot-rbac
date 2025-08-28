# RBAC 

## Development Environment Setup

### Local Postgresql

This can be setup with docker:
```bash
docker pull postgres
docker volume create postgres_data
docker run --name postgres_container -e POSTGRES_PASSWORD=your_strong_password -d -p 5432:5432 -v postgres_data:/var/lib/postgresql/data postgres
```