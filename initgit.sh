cd $(dirname $0)
echo "# demo-springboot-groovy" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:ekim197711/demo-springboot-groovy.git
git push -u origin master