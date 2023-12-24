# fuzzer

A Clojure program to fuzz edn-rs.

## Usage

`edn-rs` currently does not support arbitrary int/floats. A WIP implementation exists at https://github.com/Grinkers/edn-rs/tree/arbitrarynums. The `libedn-rs` in this repo points to this branch.

## TODO

Fuzz non-ednable.

Non-linux.

Makefile or babashka tasks.

Point to non-local edn-rs version once fuzzing is stable.

## License

See latest Clojure license for
[generators.clj](/src/clojure/test_clojure/generators.clj)

For everything else in this repo see [LICENSE](/LICENSE)
