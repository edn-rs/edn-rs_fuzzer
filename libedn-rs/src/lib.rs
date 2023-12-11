use std::str::FromStr;

use edn_rs::Edn;
use jni::objects::{JClass, JString};
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_foo_bar_Rust_roundtripRust<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    edn: JString<'local>,
) -> JString<'local> {
    let edn: String = env
        .get_string(&edn)
        .expect("Couldn't get java string!")
        .into();

    let edn = {
        let s = Edn::from_str(&edn);
        match s {
            Ok(edn) => format!("{}", edn),
            Err(err) => format!("{:?}", err),
        }
    };

    let output = env.new_string(edn).expect("Couldn't create java string");
    output
}
