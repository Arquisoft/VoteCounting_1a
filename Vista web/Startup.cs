using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ASWneo.Startup))]
namespace ASWneo
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
